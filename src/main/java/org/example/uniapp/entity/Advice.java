package org.example.uniapp.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Advice)表实体类
 *
 * @author 12444
 * @since 2024-03-21 10:56:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Advice  {

    private Integer id;

    private String title;

    private String solution;

    private String image;
}

