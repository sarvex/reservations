package com.sarvex.landon.data.repository;

import com.sarvex.landon.data.entity.Guest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sarvex on 13/03/2017.
 */

@Repository
public interface GuestRepository extends PagingAndSortingRepository<Guest, Long> {

}
