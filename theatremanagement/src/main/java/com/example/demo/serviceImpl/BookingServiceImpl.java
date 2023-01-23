package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Cinema;
import com.example.demo.entity.ShowDetails;
import com.example.demo.entity.Theatre;
import com.example.demo.entity.User;
import com.example.demo.exceptionhandler.NotFoundException;
import com.example.demo.exceptionhandler.TheatreNotFoundException;
import com.example.demo.exceptionhandler.UserNotAllowedException;
import com.example.demo.model.RequestBooking;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.CinemaRepository;
import com.example.demo.repository.ShowRepository;
import com.example.demo.repository.TheatreRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingrepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CinemaRepository cinemaRepository;

	@Autowired
	TheatreRepository theatreRepository;

	@Autowired
	ShowRepository showDetailsidRepository;

	@Override
	public Booking savebooking(RequestBooking booking, long userid) {

		User findById = userRepository.findById(userid).orElseThrow(() -> new TheatreNotFoundException("" + userid));
		String getuserRoll = findById.getRole();
		if (getuserRoll.equalsIgnoreCase("admin")) {

			Cinema obj = cinemaRepository.findById(userid).orElseThrow(() -> new TheatreNotFoundException("" + userid));

			Theatre ob1 = theatreRepository.findById(userid)
					.orElseThrow(() -> new TheatreNotFoundException("" + userid));

			ShowDetails obj2 = showDetailsidRepository.findById(userid)
					.orElseThrow(() -> new TheatreNotFoundException("" + userid));

			Booking booking1 = new Booking();

			booking1.setCinema(obj);
			booking1.setShowdetails(obj2);
			booking1.setTheatre(ob1);
			return bookingrepository.save(booking1);
		} else {
			throw new UserNotAllowedException("admin only allowed");
		}

	}

	@Override
	public List<Booking> getAllBooking() {

		return bookingrepository.findAll();
	}

	@Override
	public Booking getBookingById(long id) {
		Booking findById = bookingrepository.findById(id).orElseThrow(() -> new NotFoundException("" + id));

		return findById;
	}

//	@Override
//	public Booking updateBooking(long id, RequestBooking booking, long userid) {
//
//		User findById = userRepository.findById(userid).orElseThrow(() -> new TheatreNotFoundException("" + userid));
//		String getuserRoll = findById.getUser_role();
//
//		Booking obj = null;
//
//		if (getuserRoll.equalsIgnoreCase("admin")) {
//			obj = bookingrepository.findById(id).orElseThrow(() -> new TheatreNotFoundException("" + id));
//
//			Cinema obj1 = cinemaRepository.findById(userid)
//					.orElseThrow(() -> new TheatreNotFoundException("" + userid));
//			;
//			Theatre ob1 = theatreRepository.findById(userid)
//					.orElseThrow(() -> new TheatreNotFoundException("" + userid));
//			;
//			ShowDetails obj2 = showDetailsidRepository.findById(userid)
//					.orElseThrow(() -> new TheatreNotFoundException("" + userid));
//			;
//			Booking booking1 = new Booking();
//
//			booking1.setCinema(obj1);
//			booking1.setShowdetails(obj2);
//			booking1.setTheatre(ob1);
//			return bookingrepository.save(booking1);
//		} else {
//
//			throw new UserNotAllowedException("admin only allowed");
//		}
//	}

	@Override
	public void deleteBooking(long id) {

		Optional<Booking> findById = bookingrepository.findById(id);
		if (findById.isPresent()) {

			bookingrepository.deleteById(id);

		} else {

			throw new NotFoundException("Id not present");
		}

	}

}
