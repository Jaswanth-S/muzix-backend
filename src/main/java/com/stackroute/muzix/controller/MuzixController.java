package com.stackroute.muzix.controller;


import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exception.TrackAlreadyExistException;
import com.stackroute.muzix.exception.TrackNotFoundException;
import com.stackroute.muzix.service.MuzixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/muzix")
public class MuzixController {

    private ResponseEntity responseEntity;
    private MuzixService muzixService;


    @Autowired

    public MuzixController(final MuzixService muzixService) {
        this.muzixService = muzixService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrackToWishList(@RequestBody Track track) throws TrackAlreadyExistException{
        try {
            muzixService.saveTrackToWishList(track);
            responseEntity = new ResponseEntity(track , HttpStatus.CREATED);
        } catch (TrackAlreadyExistException e) {

            throw new TrackAlreadyExistException();
        }
        catch (Exception e)
        {
            responseEntity = new ResponseEntity<>("Error  !!!Try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackFromWishList(@PathVariable("id") String id) throws TrackNotFoundException{


        try {
            muzixService.deleteTrackFromWishList(id);
            responseEntity = new ResponseEntity("Successfully deleted !!!", HttpStatus.OK);
        } catch (TrackNotFoundException e) {

           throw new TrackNotFoundException();
        }
        catch (Exception exception){
            responseEntity = new ResponseEntity("Error !!! Try after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping("track/{id}")
    public ResponseEntity<?> updateCommentForTrack(@RequestBody Track track , @PathVariable("id") String id) throws TrackNotFoundException{


        try{
            Track updatedTrack = muzixService.updateCommentForTrack(track.getComments() ,id);
            responseEntity = new ResponseEntity(track , HttpStatus.OK);
        } catch (TrackNotFoundException e) {

            throw new TrackNotFoundException();
        }
        catch (Exception e)
        {
            responseEntity = new ResponseEntity("Error !! Try after sometime" , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;

    }

    @GetMapping("tracks")
    public ResponseEntity<?> getAllTrackFromWishList(){


        try{

            responseEntity = new ResponseEntity(muzixService.getAllTrackFromWishList() , HttpStatus.OK);

        }catch (Exception e){
            responseEntity = new ResponseEntity("Error !!! Try after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;

    }


}
