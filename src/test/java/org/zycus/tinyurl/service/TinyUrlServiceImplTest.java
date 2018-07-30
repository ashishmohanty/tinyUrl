package org.zycus.tinyurl.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.zycus.tinyurl.dao.TinyUrlDao;

@RunWith(MockitoJUnitRunner.class)
public class TinyUrlServiceImplTest {
	@Mock
	private TinyUrlDao tinyUrlDao;
	@InjectMocks
	private TinyUrlServiceImpl tinyUrlServiceImpl;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateTinyUrl() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

}
