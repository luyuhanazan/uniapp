package org.example.uniapp.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (User)表实体类
 *
 * @author 12444
 * @since 2024-03-21 10:56:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;

    private String nickname;

    private Integer age;

    private String phone;

    private Double height;

    private Double weight;

    private Double gfrValue;

    private String activityIntensity;

    private String dialysisStatus;

    /**
     * 并发症
     */
    private String complications;

    /**
     * 饮食偏好
     */
    private String dietaryPreference;

    private String sex;

    private String password;

    private String allergy;


}

