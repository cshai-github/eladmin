package com.love.module.system.rest;

import com.love.module.system.service.MonitorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MonitorController
 * @Description
 * @Author ocean
 * @CreateDate 2020/11/10
 * @Version 1.0.0
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "系统-服务监控管理")
@RequestMapping("/api/monitor")
public class MonitorController {

    private final MonitorService serverService;

    /**
     * @description
     * @return {@link ResponseEntity<Object>}
     */
    @GetMapping
    @ApiOperation("查询服务监控")
    @PreAuthorize("@el.check('monitor:list')")
    public ResponseEntity<Object> query() {
        return new ResponseEntity<>(serverService.getServers(), HttpStatus.OK);
    }
}
