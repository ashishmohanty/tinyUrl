package org.zycus.tinyurl.resource;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.zycus.tinyurl.service.TinyUrlService;

@RunWith(MockitoJUnitRunner.class)
public class TinyUrlResourceTest {
	@Mock
	private TinyUrlService tinyUrlService;
	@InjectMocks
	private TinyUrlResource tinyUrlResource;

	@Before
	public void setUp() throws Exception {
	//Mockito.initMocks();
	}

	

}
