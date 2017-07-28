package apptsched.services;

import apptsched.domain.Appointment;

public interface AppointmentService {

    Appointment save(Appointment object);

    Iterable<Appointment> save(Iterable<Appointment> objectIterable);

    Appointment findOne(Integer id);

    boolean exists(Integer id);

    Iterable<Appointment> findAll();

    long count();

    void delete(Integer id);

    void delete(Appointment object);

    void delete(Iterable<Appointment> objectIterable);

    void deleteAll();
}