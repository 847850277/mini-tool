package com.zp.reactor.core.handson;

import com.zp.reactor.core.handson.domain.User;
import com.zp.reactor.core.handson.repository.ReactiveRepository;
import com.zp.reactor.core.handson.repository.ReactiveUserRepository;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.tools.agent.ReactorDebugAgent;

/**
 * Learn how to transform values.
 *
 * @author Sebastien Deleuze
 */
public class Part04TransformTest {

	Part04Transform workshop = new Part04Transform();
	ReactiveRepository<User> repository = new ReactiveUserRepository();

	//========================================================================================

	@Test
	public void transformMono() {
		ReactorDebugAgent.init();
		//Hooks.onOperatorDebug();

		Mono<User> mono = repository.findFirst();
		//Mono<User> userMono = workshop.capitalizeOne(mono);
		StepVerifier.create(workshop.capitalizeOne(mono))
				.expectNext(new User("SWHITE", "SKYLER", "WHITE"))
				.verifyComplete();
	}

	//========================================================================================

	@Test
	public void transformFlux() {
		Flux<User> flux = repository.findAll();
		StepVerifier.create(workshop.capitalizeMany(flux))
				.expectNext(
						new User("SWHITE", "SKYLER", "WHITE"),
						new User("JPINKMAN", "JESSE", "PINKMAN"),
						new User("WWHITE", "WALTER", "WHITE"),
						new User("SGOODMAN", "SAUL", "GOODMAN"))
				.verifyComplete();
	}

	//========================================================================================

	@Test
	public void  asyncTransformFlux() {
		Flux<User> flux = repository.findAll();
		StepVerifier.create(workshop.asyncCapitalizeMany(flux))
				.expectNext(
						new User("SWHITE", "SKYLER", "WHITE"),
						new User("JPINKMAN", "JESSE", "PINKMAN"),
						new User("WWHITE", "WALTER", "WHITE"),
						new User("SGOODMAN", "SAUL", "GOODMAN"))
				.verifyComplete();
	}


}
