package com.zp.reactor.core.handson;

import com.zp.reactor.core.handson.domain.User;
import com.zp.reactor.core.handson.repository.ReactiveRepository;
import com.zp.reactor.core.handson.repository.ReactiveUserRepository;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Learn how to turn Reactive API to blocking one.
 *
 * @author Sebastien Deleuze
 */
public class Part10ReactiveToBlockingTest {

	Part10ReactiveToBlocking workshop = new Part10ReactiveToBlocking();
	ReactiveRepository<User> repository = new ReactiveUserRepository();

//========================================================================================

	@Test
	public void mono() {
		Mono<User> mono = repository.findFirst();
		User user = workshop.monoToValue(mono);
		assertThat(user).isEqualTo(User.SKYLER);
	}



}
