package com.example.appkata.integartion;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import com.example.appkata.account.application.CreateAccountRequest;
import com.example.appkata.account.application.CreateAccountResponse;
import com.example.appkata.account.application.FindAccountResponse;
import com.example.appkata.account.application.UpdateAccountRequest;
import com.example.appkata.account.application.UpdateAccountResponse;
import com.example.appkata.account.infra.EmailSender;
import com.example.appkata.fixture.AccountFixture;
import com.example.appkata.fixture.SessionFixture;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(OutputCaptureExtension.class)
class AccountApiIntegrationTest {

	@Autowired ObjectMapper objectMapper;
	@Autowired MockMvc mockMvc;
	@SpyBean
	EmailSender emailSender;

	@Test
	void 회원_등록_요청(CapturedOutput capturedOutput) throws Exception {
		// given
		String username = "joongseok";
		String email = "ejoongseok@gamil.com";
		CreateAccountRequest request = new CreateAccountRequest(username, email);

		// when
		MockHttpServletResponse response = mockMvc.perform(post("/accounts")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(request))
		).andReturn().getResponse();

		// then
		Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
		CreateAccountResponse createAccountResponse = objectMapper.readValue(response.getContentAsString(),
			CreateAccountResponse.class);
		Assertions.assertThat(createAccountResponse.getId()).isPositive();
		Assertions.assertThat(createAccountResponse.getName()).isEqualTo(username);
		Assertions.assertThat(createAccountResponse.getEmail()).isEqualTo(email);


		verify(emailSender, times(1)).sendEmail(email, username);
		String consoleEmailFormat = String.format("[EmailSender] 이메일을 보냅니다. email: %s, username: %s", email, username);
		Assertions.assertThat(capturedOutput.getOut()).contains(consoleEmailFormat);
	}

	@Test
	@Transactional
	void 회원_수정_요청() throws Exception {
		// given
		MockHttpSession session = SessionFixture.getLoginSession(mockMvc, objectMapper);
		String expectedUsername = "joongSeok";
		UpdateAccountRequest request = new UpdateAccountRequest(expectedUsername);

		// when
		MockHttpServletResponse response = mockMvc.perform(patch("/accounts")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(request))
			.session(session)
		).andReturn().getResponse();

		// then
		Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		UpdateAccountResponse updateAccountResponse = objectMapper.readValue(response.getContentAsString(),
			UpdateAccountResponse.class);
		Assertions.assertThat(updateAccountResponse.getName()).isEqualTo(expectedUsername);
	}

	@Test
	void 회원_삭제_요청() throws Exception {
		// given

		// when
		MockHttpServletResponse response = mockMvc.perform(delete("/accounts")
			.session(SessionFixture.getLoginSession(mockMvc, objectMapper))
		).andReturn().getResponse();
		// then
		Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	}

	@Test
	void 회원_조회_요청() throws Exception {
		// given

		// when
		MockHttpServletResponse response = mockMvc.perform(get("/accounts"))
			.andReturn().getResponse();

		// then
		Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		FindAccountResponse findAccountResponse = objectMapper.readValue(response.getContentAsString(),
			FindAccountResponse.class);
		Assertions.assertThat(findAccountResponse.getUsername()).isEqualTo(AccountFixture.FIXTURE_USER_NAME);
		Assertions.assertThat(findAccountResponse.getEmail()).isEqualTo(AccountFixture.FIXTURE_USER_EMAIL);
	}

}
