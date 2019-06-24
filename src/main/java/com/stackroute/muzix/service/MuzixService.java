package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exception.TrackAlreadyExistException;
import com.stackroute.muzix.exception.TrackNotFoundException;

import java.util.List;

public interface MuzixService {

     Track saveTrackToWishList(Track track) throws TrackAlreadyExistException;
     boolean deleteTrackFromWishList(String id) throws TrackNotFoundException;
     Track updateCommentForTrack(String comments, String id) throws TrackNotFoundException;
     List<Track> getAllTrackFromWishList() throws Exception;

}
