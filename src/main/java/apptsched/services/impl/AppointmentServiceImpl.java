package apptsched.services.impl;

import apptsched.domain.Appointment;
import apptsched.repositories.AppointmentRepository;
import apptsched.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment save(Appointment object) {
        return appointmentRepository.save(object);
    }

    @Override
    public Iterable<Appointment> save(Iterable<Appointment> objectIterable) {
        return appointmentRepository.save(objectIterable);
    }

    @Override
    public Appointment findOne(Integer id) {
        return appointmentRepository.findOne(id);
    }

    @Override
    public boolean exists(Integer id) {
        return appointmentRepository.exists(id);
    }

    @Override
    public Iterable<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public long count() {
        return appointmentRepository.count();
    }

    @Override
    public void delete(Integer id) {
        appointmentRepository.delete(id);
    }

    @Override
    public void delete(Appointment object) {
        appointmentRepository.delete(object);
    }

    @Override
    public void delete(Iterable<Appointment> objectIterable) {
        appointmentRepository.delete(objectIterable);
    }

    @Override
    public void deleteAll() {
        appointmentRepository.deleteAll();
    }
}
