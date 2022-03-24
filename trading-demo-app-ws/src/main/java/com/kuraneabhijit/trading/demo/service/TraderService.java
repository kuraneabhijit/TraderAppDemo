package com.kuraneabhijit.trading.demo.service;

import java.util.ArrayList;

import com.kuraneabhijit.trading.demo.shared.dto.TraderDto;

public interface TraderService {
	
	TraderDto createTrader(TraderDto traderDto);
	ArrayList<TraderDto> getTraders();
	void deleteTrader(String traderId);
	TraderDto updateTrader(String traderId, TraderDto traderDto);

}
