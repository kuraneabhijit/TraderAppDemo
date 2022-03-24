package com.kuraneabhijit.trading.demo.ui.controller;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kuraneabhijit.trading.demo.service.impl.TraderServiceImpl;
import com.kuraneabhijit.trading.demo.shared.dto.TraderDto;
import com.kuraneabhijit.trading.demo.ui.model.request.TraderDetailsRequestModel;
import com.kuraneabhijit.trading.demo.ui.model.response.TraderDetailsResponseModel;

@RestController
@RequestMapping("traders")
public class TraderController {
	@Autowired
	TraderServiceImpl traderServiceImpl;

	@GetMapping
	public ArrayList<TraderDetailsResponseModel> getTraders() {
		ArrayList<TraderDto> listTraders=traderServiceImpl.getTraders();
		ArrayList<TraderDetailsResponseModel> listTradersResponse=new ArrayList<>();
		for (TraderDto traderDetailsResponseModel : listTraders) {
			TraderDetailsResponseModel model=new TraderDetailsResponseModel();
			BeanUtils.copyProperties(traderDetailsResponseModel, model);
			listTradersResponse.add(model);
			
		}
		
		return listTradersResponse;
	}

	@PostMapping
	public TraderDetailsResponseModel createTrader(@RequestBody TraderDetailsRequestModel traderDetailsRequestModel) {
		TraderDto requestInfoDto = new TraderDto();
		BeanUtils.copyProperties(traderDetailsRequestModel, requestInfoDto);
		TraderDto createdUserDto = traderServiceImpl.createTrader(requestInfoDto);
		TraderDetailsResponseModel detailsResponseModel = new TraderDetailsResponseModel();
		BeanUtils.copyProperties(createdUserDto, detailsResponseModel);
		return detailsResponseModel;
	}

	@PutMapping(path = "/{id}")
	public TraderDetailsResponseModel updateTrader(@PathVariable String id,
			@RequestBody TraderDetailsRequestModel detailsRequestModel) {
		TraderDetailsResponseModel detailsResponseModel = new TraderDetailsResponseModel();
		TraderDto updateTraderDto = new TraderDto();
		BeanUtils.copyProperties(detailsRequestModel, updateTraderDto);
		TraderDto updatedTraderDto = traderServiceImpl.updateTrader(id, updateTraderDto);
		BeanUtils.copyProperties(updatedTraderDto, detailsResponseModel);

		return detailsResponseModel;
		}
	

	

	@DeleteMapping
	public String deleteTrader() {
		return "Delete Trader Called";
	}

}
