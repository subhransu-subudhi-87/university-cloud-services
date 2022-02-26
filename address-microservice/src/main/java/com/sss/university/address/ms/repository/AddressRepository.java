package com.sss.university.address.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sss.university.address.ms.entity.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
