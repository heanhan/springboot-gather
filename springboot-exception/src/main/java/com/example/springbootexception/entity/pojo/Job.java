package com.example.springbootexception.entity.pojo;

import com.example.springbootexception.entity.dto.UserDTO;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Classname Job
 * @Description TODO
 * @Date 2022/1/8 3:45 下午
 * @Created by zhaojh0912
 */
@Data
public class Job {

    /**
     * 工作id
     */
    @Min(value = 1, groups = UserDTO.Update.class)
    private Long jobId;

    /**
     * 工作名称
     */
    @NotNull(groups = {UserDTO.Save.class, UserDTO.Update.class})
    @Length(min = 2, max = 10, groups = {UserDTO.Save.class, UserDTO.Update.class})
    private String jobName;

    /**
     * 岗位
     */
    @NotNull(groups = {UserDTO.Save.class, UserDTO.Update.class})
    @Length(min = 2, max = 10, groups = {UserDTO.Save.class, UserDTO.Update.class})
    private String position;
}
