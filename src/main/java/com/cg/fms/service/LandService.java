package com.cg.fms.service;
/******************************
 * @author       Abu Md Faisal
 * Description : This is the Service class for Land. 
 * Created Date: 22 April, 2021 
 * Version     : v1.1.0
 *****************************/
import java.util.List;
import java.util.Optional;

import com.cg.fms.dto.Land;

public interface LandService {
	public Optional<Land> getLand(String surveyNumber);

	public Land addLand(Land land);

	public Land updateLand(Land land);

	public Land removeLandDetails(String surveyNumber);
	
	public List<Land> getAllLands();
}
