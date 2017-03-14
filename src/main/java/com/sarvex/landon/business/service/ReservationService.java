package com.sarvex.landon.business.service;

import com.sarvex.landon.business.domain.RoomReservation;
import com.sarvex.landon.data.entity.Guest;
import com.sarvex.landon.data.entity.Reservation;
import com.sarvex.landon.data.entity.Room;
import com.sarvex.landon.data.repository.GuestRepository;
import com.sarvex.landon.data.repository.ReservationRepository;
import com.sarvex.landon.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sarvex on 13/03/2017.
 */

@Service
public class ReservationService {
  private RoomRepository roomRepository;
  private GuestRepository guestRepository;
  private ReservationRepository reservationRepository;

  @Autowired
  public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository
      reservationRepository) {
    this.roomRepository = roomRepository;
    this.guestRepository = guestRepository;
    this.reservationRepository = reservationRepository;
  }

  public List<RoomReservation> getRoomReservationsForDate(Date date) {
    Iterable<Room> rooms = roomRepository.findAll();
    Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
    rooms.forEach(room -> {
      RoomReservation roomReservation = new RoomReservation();
      roomReservation.setRoomId(room.getId());
      roomReservation.setRoomName(room.getName());
      roomReservation.setRoomNumber(room.getNumber());
      roomReservationMap.put(room.getId(), roomReservation);
    });

    Iterable<Reservation> reservations = reservationRepository.findByDate(new java.sql.Date(date.getTime()));
    if (reservations != null) {
      reservations.forEach(reservation -> {
        Guest guest = guestRepository.findOne(reservation.getGuestId());
        if (guest != null) {
          RoomReservation roomReservation = roomReservationMap.get(reservation.getId());
          roomReservation.setDate(date);
          roomReservation.setFirstName(guest.getFirstName());
          roomReservation.setLastName(guest.getLastName());
          roomReservation.setGuestId(guest.getId());
        }
      });
    }

    List<RoomReservation> roomReservations = new ArrayList<>();
    for (Long roomId : roomReservationMap.keySet()) {
      roomReservations.add(roomReservationMap.get(roomId));
    }

    return roomReservations;
  }
}
