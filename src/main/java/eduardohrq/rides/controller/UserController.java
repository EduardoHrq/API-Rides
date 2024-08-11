package eduardohrq.rides.controller;

import eduardohrq.rides.models.Driver.dtos.DriverRequest;
import eduardohrq.rides.models.Driver.dtos.DriverResponse;
import eduardohrq.rides.models.Driver.dtos.DriverResponseInfo;
import eduardohrq.rides.models.Driver.service.DriverService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private final DriverService driverService;

    @PostMapping("register")
    public ResponseEntity<DriverResponse> creatingUser(@RequestBody @Valid DriverRequest driverRequest) {
        System.out.println(driverRequest.toString());
        var driver = driverService.createNewDriver(driverRequest);
        // System.out.println(driver.toString());
        return ResponseEntity.ok(driver);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteUser(@PathVariable UUID id) {
        var res = this.driverService.removeDriver(id);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping("{id}/info")
    public ResponseEntity<DriverResponseInfo> infos(@PathVariable UUID id) {
        return ResponseEntity.ok(this.driverService.getInfo(id));
    }
}
