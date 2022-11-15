package com.kesizo.demo.services.uploadfilesservice

import com.kesizo.demo.services.uploadfilesservice.service.UploadFileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UploadFilesServiceApplication : CommandLineRunner {

	@Autowired
	lateinit var uploadFileService: UploadFileService

	override fun run(vararg args: String?) {
		uploadFileService.init()
			.onFailure { throw RuntimeException("System cannot start up because no uploads folder is set up") }
	}
}

fun main(args: Array<String>) {
	runApplication<UploadFilesServiceApplication>(*args)
}

