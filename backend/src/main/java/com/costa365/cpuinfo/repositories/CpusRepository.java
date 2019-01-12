package com.costa365.cpuinfo.repositories;

import com.costa365.cpuinfo.models.Cpus;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CpusRepository extends MongoRepository<Cpus, String> {
  Cpus findBy_id(ObjectId _id);
  @Query("{ 'name' : { '$regex' : ?0 , $options: 'i'}}")
  List<Cpus> findByNameLike(String name);
}
