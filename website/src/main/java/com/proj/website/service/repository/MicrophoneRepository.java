package com.proj.website.service.repository;

import com.proj.website.model.goods.Microphone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicrophoneRepository extends CrudRepository<Microphone, Long> {

}
