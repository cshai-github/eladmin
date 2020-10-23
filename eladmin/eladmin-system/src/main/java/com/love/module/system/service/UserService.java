package com.love.module.system.service;

import com.love.module.system.domain.User;
import com.love.module.system.service.dto.UserDto;
import com.love.module.system.service.dto.UserQueryCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName UserService
 * @description 用户接口
 * @author ocean
 * @createDate 2020/10/23
 * @version 1.0.0
 */
public interface UserService {

    /**
     * @describe 根据Id查询
     * @param id ID
     * @return com.love.module.system.service.dto.UserDto
     */
    UserDto findById(long id);

    /**
     * @describe 新增用户
     * @param user 用户
     * @return void
     */
    void create(User user);

    /**
     * @describe 编辑用户
     * @param user /
     * @return void
     */
    void update(User user);

    /**
     * @describe 删除用户
     * @param ids /
     * @return void
     */
    void delete(Set<Long> ids);

    /**
     * @describe 根据用户名查询
     * @param userName /
     * @return com.love.module.system.service.dto.UserDto
     */
    UserDto findByName(String userName);

    /**
     * @describe 修改密码
     * @param username 用户名
     * @param encryptPassword 密码
     * @return void
     */
    void updatePass(String username, String encryptPassword);

    /**
     * @describe 修改头像
     * @param file 文件
     * @return java.util.Map<java.lang.String, java.lang.String>
     */
    Map<String, String> updateAvatar(MultipartFile file);

    /**
     * @describe 修改邮箱
     * @param username 用户名
     * @param email 邮箱
     * @return void
     */
    void updateEmail(String username, String email);

    /**
     * @describe 查询全部
     * @param criteria 条件
     * @param pageable 分页参数
     * @return java.lang.Object
     */
    Object queryAll(UserQueryCriteria criteria, Pageable pageable);

    /**
     * @describe 查询全部不分页
     * @param criteria 条件
     * @return java.util.List<com.love.module.system.service.dto.UserDto>
     */
    List<UserDto> queryAll(UserQueryCriteria criteria);

    /**
     * @describe 导出数据
     * @param queryAll 待导出的数据
     * @param response /
     * @return void
     */
    void download(List<UserDto> queryAll, HttpServletResponse response) throws IOException;

    /**
     * @describe 用户自助修改资料
     * @param resources /
     * @return void
     */
    void updateCenter(User resources);
}
