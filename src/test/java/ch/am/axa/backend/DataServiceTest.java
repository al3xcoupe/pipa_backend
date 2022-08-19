package ch.am.axa.backend;

import ch.am.axa.backend.entity.ApplikationEntity;
import ch.am.axa.backend.entity.TranslationEntity;
import ch.am.axa.backend.repository.TranslationRepository;
import ch.am.axa.backend.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

/**
 * @author : Alexander Margraf
 * @version : 18.08.2022
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class DataServiceTest {

	@MockBean
	private TranslationRepository translationRepository;

	@Autowired
	private DataService dataService;

	@Test
	public void getTranslations(){

		TranslationEntity entity = new TranslationEntity();
		entity.setText_id("ch.am.axa.hello");
		entity.setContent_de("Hallo");
		entity.setContent_en("Hello");
		entity.setContent_it("Ciao");
		entity.setContent_fr("Bonjour");

		ApplikationEntity applikation = new ApplikationEntity();
		applikation.setApp_id("2");
		applikation.setApp_owner_email("a@a.com");

		entity.setApp_idfs(applikation);

		ArrayList<TranslationEntity> expectedTranslation = new ArrayList<>();
		expectedTranslation.add(entity);

		given(translationRepository.findAll()).willReturn(expectedTranslation);

		Iterable<TranslationEntity> actualTranslation = dataService.getAllTranslationEntrys();

		assertEquals(expectedTranslation, actualTranslation);
	}

	@Test
	public void getTranslationById(){
		TranslationEntity entity = new TranslationEntity();
		entity.setText_id("ch.am.axa.hello");
		entity.setContent_de("Hallo");
		entity.setContent_en("Hello");
		entity.setContent_it("Ciao");
		entity.setContent_fr("Bonjour");

		ApplikationEntity applikation = new ApplikationEntity();
		applikation.setApp_id("2");
		applikation.setApp_owner_email("a@a.com");

		entity.setApp_idfs(applikation);

		given(translationRepository.findById("ch.am.axa.hello")).willReturn(Optional.of(entity));

		Optional<TranslationEntity> actualTranslation = dataService.getTranslationEntryById("ch.am.axa.hello");

		assertEquals(actualTranslation.isPresent(), true);
	}

	@Test
	public void getTranslationByIdFalse(){
		given(translationRepository.findById(anyString())).willReturn(Optional.empty());
		Optional<TranslationEntity> actualTranslation = dataService.getTranslationEntryById("ch.am.axa.hello");

		assertEquals(actualTranslation.isPresent(), false);
	}


	@Test
	public void addNewTranslation(){
		TranslationEntity entity = new TranslationEntity();
		entity.setText_id("ch.am.axa.hello3");
		entity.setContent_de("Hallo");
		entity.setContent_en("Hello");
		entity.setContent_it("Ciao");
		entity.setContent_fr("Bonjour");

		ApplikationEntity applikation = new ApplikationEntity();
		applikation.setApp_id("1");

		int countBefore = (List) dataService.getAllTranslationEntrys();
		assertEquals(entity, dataService.addTranslation(entity));§

	}

}
