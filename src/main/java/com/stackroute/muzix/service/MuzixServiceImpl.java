package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exception.TrackAlreadyExistException;
import com.stackroute.muzix.exception.TrackNotFoundException;
import com.stackroute.muzix.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuzixServiceImpl implements MuzixService {

    private MuzixRepository muzixRepository;
    private Track track;

    @Autowired
    public MuzixServiceImpl(final MuzixRepository muzixRepository)
    {
        this.muzixRepository = muzixRepository;
    }


    public MuzixServiceImpl() {
    }

    @Override
    public Track saveTrackToWishList(Track track) throws TrackAlreadyExistException {
        Optional optional = muzixRepository.findById(track.getTrackId());
        if((optional.isPresent())){
            throw new TrackAlreadyExistException();
        }
       return muzixRepository.insert(track);
    }

    @Override
    public boolean deleteTrackFromWishList(String id) throws TrackNotFoundException {

        boolean status = false;
        Optional optional = muzixRepository.findById(id);
        if(optional.isPresent()) {
            muzixRepository.deleteById(id);
            status = true;
        }
        else{
            throw new TrackNotFoundException();
        }

        return status;
    }

    @Override
    public Track updateCommentForTrack(String comments, String id) throws TrackNotFoundException {
        Optional optional = muzixRepository.findById(id);
        if(optional.isPresent()){
            track = muzixRepository.findById(id).get();
            track.setComments(comments);

             muzixRepository.save(track);
        }
        else
        {
            throw new TrackNotFoundException();
        }
        return track;
    }

    @Override
    public List<Track> getAllTrackFromWishList() throws Exception {
        return muzixRepository.findAll();

    }
}
