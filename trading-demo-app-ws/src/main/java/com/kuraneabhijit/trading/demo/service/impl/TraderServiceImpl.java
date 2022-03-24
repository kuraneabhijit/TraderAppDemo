package com.kuraneabhijit.trading.demo.service.impl;

import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuraneabhijit.trading.demo.repository.TraderRepository;
import com.kuraneabhijit.trading.demo.repository.entity.TraderEntity;
import com.kuraneabhijit.trading.demo.service.TraderService;
import com.kuraneabhijit.trading.demo.shared.Utils;
import com.kuraneabhijit.trading.demo.shared.dto.TraderDto;

@Service
public class TraderServiceImpl implements TraderService {
	@Autowired
	TraderRepository traderRepository;
	@Autowired
	Utils utils;

	@Override
	public TraderDto createTrader(TraderDto traderDto) {
		TraderEntity traderInfo=new TraderEntity();
		BeanUtils.copyProperties(traderDto, traderInfo);
		traderInfo.setTraderId(utils.generateUserId());
		TraderEntity savedInfoEntity=traderRepository.save(traderInfo);
		TraderDto savedInfoDto=new TraderDto();
		BeanUtils.copyProperties(savedInfoEntity, savedInfoDto);		
		return savedInfoDto;
	}

	@Override
	public void deleteTrader(String traderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<TraderDto> getTraders() {
		Iterable<TraderEntity> traderList = traderRepository.findAll();
		ArrayList<TraderDto> traderListDto=new ArrayList<>();
		for (TraderEntity traderEntity : traderList) {
			TraderDto savedInfoDto=new TraderDto();
			BeanUtils.copyProperties(traderEntity, savedInfoDto);	
			traderListDto.add(savedInfoDto);
		}
		return traderListDto;
	}

	@Override
	public TraderDto updateTrader(String traderId, TraderDto traderDto) {
		TraderEntity traderEntity =traderRepository.findByTraderId(traderId);
		
		if(traderEntity==null)
			throw new RuntimeException("Trader does not exits");
		
		traderEntity.setFirstName(traderDto.getFirstName());
		traderEntity.setLastName(traderDto.getLastName());

		TraderEntity updatedTraderDetails = traderRepository.save(traderEntity);
		TraderDto returnUpdatedInfo = new TraderDto();
		BeanUtils.copyProperties(updatedTraderDetails, returnUpdatedInfo);

		return returnUpdatedInfo;
		
	}

}
