package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;
import com.example.demo.entity.BookingSeats;
import com.example.demo.entity.Cinema;
import com.example.demo.entity.ShowDetails;
import com.example.demo.entity.Theatre;
import com.example.demo.entity.User;
import com.example.demo.exceptionhandler.NotFoundException;
import com.example.demo.exceptionhandler.TheatreNotFoundException;
import com.example.demo.exceptionhandler.UserNotAllowedException;
import com.example.demo.model.BookingResponce;
import com.example.demo.model.RequestBooking;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.BookingSetsRepository;
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
	@Autowired
	BookingSetsRepository bookingSetsRepository;

	@Override
	public Booking savebooking(RequestBooking booking) {

		User findById = userRepository.findById(booking.getUserId()).orElseThrow(() -> new UserNotAllowedException(""));
		//String getuserRoll = findById.getRole();
		//if (getuserRoll.equalsIgnoreCase("user")) {

			Cinema obj = cinemaRepository.findById(booking.getCinemaId()).orElseThrow(() -> new NotFoundException(""));

			Theatre ob1 = theatreRepository.findById(booking.getTheatreId())
					.orElseThrow(() -> new TheatreNotFoundException(""));

			ShowDetails obj2 = showDetailsidRepository.findById(booking.getShowDetailsid())
					.orElseThrow(() -> new NotFoundException("" ));
			
			Booking booking1 = new Booking();
			booking1.setUser(findById);
			booking1.setCinema(obj);
			booking1.setShowdetails(obj2);
			booking1.setTheatre(ob1);
			
			
			List<BookingSeats> list = new ArrayList<>();
			
			for (Integer seats : booking.getSeatNumber()) {
				BookingSeats book = new BookingSeats();
				book.setBooking(booking1);
				book.setSeatNumber(seats);
				list.add(book);
			}
			
			booking1.setSeats(list);
			
			return bookingrepository.save(booking1);
			
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

	@Override
	public List<Booking> findUser(long id) {
		
		 List<Booking> listBooking= bookingrepository.findByUser_id(id);

		return listBooking;
		
	}
	
	
	public List<BookingResponce> findBookingDetails(long id) {
		
		 List<Booking> listBooking= bookingrepository.findByUser_id(id);
		 
		 List<BookingResponce> booked =new ArrayList<>();
		 for(Booking b:listBooking) {
			 BookingResponce book =new BookingResponce();
			 book.setPoster(b.getCinema().getPoster());
			// theatreName
			
			 book.setMovieName(b.getCinema().getMovieName());
			 book.setCity(b.getTheatre().getAddress().getCity());
			 book.setState(b.getTheatre().getAddress().getState());
			 book.setNumber(b.getTheatre().getAddress().getPhoneNumber());
			 book.setSeatNo(b.getSeats());
			 book.setShowDate(b.getShowdetails().getDate());
			 book.setShowTime(b.getShowdetails().getShowTime());
			 book.setTheatreName(b.getTheatre().getTheatrename());
			 
			 booked.add(book);
			 
		 }
		 
		 
		 
		return booked;
		 
		 

		
		
	}
	
	
	public List<Integer> getSeatsByBookingAndShow(long showId) {
		List<Integer> seats = new ArrayList<>();
		Optional<ShowDetails> optional = showDetailsidRepository.findById(showId);
		if(optional.isPresent()) {
			List<Booking> listBooking= bookingrepository.findByShowdetailsId(showId);
			
			for (Booking booking : listBooking) {
				List<Integer> list =  booking.getSeats().stream().map(e -> e.getSeatNumber()).collect(Collectors.toList());
				seats.addAll(list);
			}
		}
		return seats;
	}

}
