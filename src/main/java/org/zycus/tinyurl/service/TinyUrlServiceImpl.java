package org.zycus.tinyurl.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zycus.tinyurl.converter.IDConverter;
import org.zycus.tinyurl.dao.TinyUrlDao;

@Service
public class TinyUrlServiceImpl implements TinyUrlService {

	@Autowired
	private TinyUrlDao urlRepository;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(TinyUrlServiceImpl.class);

	@Override
	public String shortenURL(String localURL, String longUrl) {
		LOGGER.info("Shortening {}", longUrl);
		Long id = urlRepository.incrementID();
		String uniqueID = IDConverter.INSTANCE.createUniqueID(id);
		urlRepository.saveUrl("url:" + id, longUrl);
		String baseString = formatLocalURLFromShortener(localURL);
		String shortenedURL = baseString + uniqueID;
		return shortenedURL;
	}

	@Override
	public String getLongURLFromID(String uniqueID) throws Exception {
		Long dictionaryKey = IDConverter.INSTANCE
				.getDictionaryKeyFromUniqueID(uniqueID);
		String longUrl = urlRepository.getUrl(dictionaryKey);
		LOGGER.info("Converting shortened URL back to {}", longUrl);
		return longUrl;
	}

	private String formatLocalURLFromShortener(String localURL) {
		String[] addressComponents = localURL.split("/");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < addressComponents.length - 1; ++i) {
			sb.append(addressComponents[i]);
		}
		sb.append('/');
		return sb.toString();
	}
}