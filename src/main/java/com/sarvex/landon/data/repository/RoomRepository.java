package com.sarvex.landon.data.repository;

import com.sarvex.landon.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sarvex on 13/03/2017.
 */

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
  Room findByNumber(String number);
}
