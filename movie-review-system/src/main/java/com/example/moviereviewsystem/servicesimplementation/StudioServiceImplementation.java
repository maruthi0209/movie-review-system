package com.example.moviereviewsystem.servicesimplementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moviereviewsystem.models.Studio;
import com.example.moviereviewsystem.repositories.IStudioRepository;
import com.example.moviereviewsystem.services.IStudioService;

@Service
public class StudioServiceImplementation implements IStudioService{
	
	@Autowired
	private IStudioRepository iStudioRepository;

	@Override
	@Transactional
	public Studio getStudio(Long studioId) {
		Studio studio = iStudioRepository.getReferenceById(studioId);
		return studio;
	}

	@Override
	@Transactional
	public List<Studio> getAllStudio() {
		List<Studio> studiosList = new ArrayList<Studio>();
		studiosList = iStudioRepository.findAll();
		return studiosList;
	}

	@Override
	@Transactional
	public Studio createStudio(Studio studio) {
		Studio savedStudio = iStudioRepository.save(studio);
		return savedStudio;
	}

	@Override
	@Transactional
	public Studio updateStudio(Studio studio) {
		if (iStudioRepository.existsById(studio.getStudioId())) {
			Studio existingStudio = iStudioRepository.getReferenceById(studio.getStudioId());
			existingStudio.setStudioName(studio.getStudioName());
			existingStudio.setStudioLocation(studio.getStudioLocation());
			Studio savedStudio = iStudioRepository.save(existingStudio);
			return savedStudio;
		} else {
			return studio;
		}
	}

	@Override
	@Transactional
	public boolean deleteStudio(Long studioId) {
		if (iStudioRepository.existsById(studioId)) {
			iStudioRepository.deleteById(studioId);
			return true;
		} else {
			return false;
		}
	}
	
	
}
