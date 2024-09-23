package com.fls.animecommunity.animesanctuary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fls.animecommunity.animesanctuary.model.notification.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByRecipientIdAndReadFalse(Long recipientId);
}
