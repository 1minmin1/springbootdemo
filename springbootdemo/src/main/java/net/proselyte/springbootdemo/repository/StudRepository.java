package net.proselyte.springbootdemo.repository;

import net.proselyte.springbootdemo.model.Stud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudRepository extends JpaRepository<Stud, Long> {

}
