package com.lx.board.domain.base.packageTemplate.repository.entity;

import com.lx.board.domain.base.entity.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.generator.Generator;

@Entity(name = "TEMP")
@Getter
@NoArgsConstructor
public class TemplateEntity extends BaseTimeEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
}
