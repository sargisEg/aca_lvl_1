package com.aca.exam.exam3.facade;

public interface UserPlateNumberFacade {

    UserTakePlateNumberResponseDto takePlateNumber(UserTakePlateNumberRequestDto dto);

    GetAllUserNumbersResponseDto getAllUserNumbers(GetAllUserNumbersRequestDto dto);
}
