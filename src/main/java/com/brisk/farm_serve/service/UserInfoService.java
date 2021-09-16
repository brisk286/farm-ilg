package com.brisk.farm_serve.service;

import com.brisk.farm_serve.entity.User;
import com.brisk.farm_serve.result.CommonResult;
import org.springframework.stereotype.Service;

public interface UserInfoService {

   User getUserById(Long user_id);

}
