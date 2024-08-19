package com.fls.animecommunity.animesanctuary.controller;

import com.fls.animecommunity.animesanctuary.model.note.Note;
import com.fls.animecommunity.animesanctuary.model.note.dto.NoteRequestsDto;
import com.fls.animecommunity.animesanctuary.model.note.dto.NoteResponseDto;
import com.fls.animecommunity.animesanctuary.model.note.dto.SuccessResponseDto;
import com.fls.animecommunity.animesanctuary.service.NoteServiceImpl;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * NoteController class : Note의 CRUD기능 , api mapping 
 * DI : NoteServiceImpl
 * Method Name : createNote , getNotes , getNote , updateNote , deleteNote
 * parameter = dto: NoteResponseDto, NoteRequestsDto, SuccessResponseDto
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("api/notes")
public class NoteController {

    //DI
    private final NoteServiceImpl noteService;
    
    //create Note
    @PostMapping
    public NoteResponseDto createNote(@RequestBody NoteRequestsDto requestsDto) {
    	return noteService.createNote(requestsDto);
    }
    
    //list Note
    @GetMapping
    public List<NoteResponseDto> getNotes() {
        return noteService.getNotes();
    }
    
    //find Note
    @GetMapping("/{note_id}")
    public NoteResponseDto getNote(@PathVariable("note_id") Long id) {
        return noteService.getNote(id);
    }
    
    
    //update Note
    @PostMapping("/{note_id}")
    public NoteResponseDto updateNote(@PathVariable("note_id") Long id, 
    								  @RequestBody NoteRequestsDto requestsDto) throws Exception {
        return noteService.updateNote(id, requestsDto);
    }
    
    //delete Note
    @DeleteMapping("/{note_id}")
    public SuccessResponseDto deleteNote(@PathVariable("note_id") Long id, 
    									 @RequestBody NoteRequestsDto requestsDto) throws Exception {
        return noteService.deleteNote(id, requestsDto);
    }
}
