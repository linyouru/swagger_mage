package com.example.swagger_mage.api;

import com.example.swagger_mage.api.model.*;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api(tags = "users", description = "the Users API")
public class UsersController implements UsersApi{
    @Override
    public ResponseEntity<ApiTenantUserDetail> getCurrentUser() {
        return null;
    }

    @Override
    public ResponseEntity<ApiTenantDetail> getTenantOfCurrentUser() {
        return null;
    }

    @Override
    public ResponseEntity<ApiGetTenantSpecResponse> getTenantSpecOfCurrentUser() {
        return null;
    }

    @Override
    public ResponseEntity<Boolean> isManager(String username, Integer type) {
        System.out.println("==========isManager==========");
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Void> resetPasswordByVerificationCode(ApiResetPasswordRequest body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateCurrentUser(ApiUpdateCurrentUserProfileRequest body) {
        return null;
    }

    @Override
    public ResponseEntity<String> updateCurrentUserAvatar(MultipartFile avatar) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateCurrentUserEmail(ApiUpdateCurrentUserEmailRequest body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateCurrentUserMobile(ApiUpdateCurrentUserMobileRequest body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateCurrentUserPassword(ApiUpdateCurrentUserPasswordRequest body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateTenantOfCurrentUser(ApiTenantEditBase body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateTenantSpecOfCurrentUser(ApiUpdateSelfTenantSpecRequest body) {
        return null;
    }
}
