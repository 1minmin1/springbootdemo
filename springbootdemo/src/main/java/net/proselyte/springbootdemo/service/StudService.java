package net.proselyte.springbootdemo.service;

import net.proselyte.springbootdemo.model.Stud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.proselyte.springbootdemo.repository.StudRepository;

import java.util.List;
@Service
public class StudService  {
    private final StudRepository studRepository;
    @Autowired
    public StudService(StudRepository studRepository) {
        this.studRepository = studRepository;
    }

    public Stud findById(Long id){
        return studRepository.getOne(id);
    }

    public List<Stud> findAll(){
        return studRepository.findAll();
    }

    public Stud saveStud(Stud stud){
        return studRepository.save(stud);
    }

    public void deleteById(Long id){
        studRepository.deleteById(id);
    }
}
