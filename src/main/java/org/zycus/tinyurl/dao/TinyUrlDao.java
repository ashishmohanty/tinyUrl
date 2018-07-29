package org.zycus.tinyurl.dao;

public interface TinyUrlDao {
	
	public Long incrementID();
	public void saveUrl(String key, String longUrl);
	public String getUrl(Long id) throws Exception;
}
