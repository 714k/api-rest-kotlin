package com.victorzamudio.restfulapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import com.victorzamudio.restfulapi.models.Verb
import org.springframework.stereotype.Repository
@Repository
interface VerbsRepository : JpaRepository<Verb, Long>{
}

