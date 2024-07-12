package br.com.consoletech.application.hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {
    Optional<Hotel> findByMessageId(String messageId);

    Optional<Hotel> findById(String hotelId);
}
