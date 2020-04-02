package com.example.video.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.video.exception.DBException;
import com.example.video.model.Category;
import com.example.video.model.Level;
import com.example.video.model.ReferenceArtifact;
import com.example.video.model.ReferenceUrl;
import com.example.video.model.SampleProgram;
import com.example.video.model.Video;

class VideoDAOImplTest {
	
	@InjectMocks
	VideoDAOImpl videodao;

	 @Mock
	 private SessionFactory sessionFactory;
	   
	 @Mock
	 private Session session;
	 
	 @Mock
	 Query<Video> query;
	 
	@Spy
	List<Level> levelList = new ArrayList<Level>();

	@Spy
	List<Category> categoryList = new ArrayList<Category>();

	
	List<Video> videoList = new ArrayList<Video>();

	
	Video video = new Video();
	

	@BeforeEach
	void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		videoList=getVideoList();
		video = getVideo();
		levelList = getLevelList();
		categoryList = getCategoryList();
		when(sessionFactory.getCurrentSession()).thenReturn(session);
		when(session.createQuery(Mockito.anyString())).thenReturn(query);
	}

	
	@AfterEach
	void tearDown() throws Exception {
		doNothing().when(session).close();
	}
	public Video getVideo() {

		ReferenceArtifact referenceArtifact1 = new ReferenceArtifact();
		referenceArtifact1.setId(1);
		referenceArtifact1.setName("reference artifact example");
		referenceArtifact1.setFile("java.txt");
		referenceArtifact1.setDescription("This is a reference artifact");
		ReferenceArtifact referenceArtifact2 = new ReferenceArtifact();
		SampleProgram sampleProgram1 = new SampleProgram();
		sampleProgram1.setId(1);
		sampleProgram1.setName("sample program example");
		sampleProgram1.setFile("sample.txt");
		sampleProgram1.setDescription("This is a sample program");
		SampleProgram sampleProgram2 = new SampleProgram();
		ReferenceUrl referenceUrl1 = new ReferenceUrl();
		referenceUrl1.setId(1);
		referenceUrl1.setName("reference url example");
		referenceUrl1.setUrl("http://www.javase.com");
		referenceUrl1.setDescription("This is a reference url");
		List<ReferenceArtifact> refArtList = new ArrayList<ReferenceArtifact>();
		refArtList.add(referenceArtifact1);
		List<SampleProgram> samProgList = new ArrayList<SampleProgram>();
		samProgList.add(sampleProgram1);
		List<ReferenceUrl> refUrlList = new ArrayList<ReferenceUrl>();
		refUrlList.add(referenceUrl1);
		Level level = new Level();
		level.setId(1);
		level.setName("Level 1");
		Category category = new Category();
		category.setId(1);
		category.setName("java");
		video.setId(1);
		video.setName("java");
		video.setDisplayName("java");
		video.setUrl("https://www.javase.com");
		Time time = Time.valueOf("01:20:09");
		video.setDuration(time);
		video.setCreatedBy("Subhalakshmi");
		Timestamp createTimestamp = new Timestamp(System.currentTimeMillis());
		video.setCreatedOn(createTimestamp);
		video.setModifiedBy("Subhalakshmi");
		Timestamp modifyTimestamp = new Timestamp(System.currentTimeMillis());
		video.setModifiedOn(modifyTimestamp);
		video.setDescription("This is a java video");
		video.setLevel(level);
		video.setCategory(category);
		video.setReferenceArtifact(refArtList);
		video.setSampleProgram(samProgList);
		video.setReferenceUrl(refUrlList);
		return video;

	}
	
	public List<Video> getVideoList(){
		videoList.add(video);
		return videoList;
	}

//	@Test
//	void testGetAllVideos() throws DBException {
//		List<Video> videoList = new ArrayList<Video>();
//		Video video = new Video();
//		ReferenceArtifact referenceArtifact1 = new ReferenceArtifact();
//		referenceArtifact1.setId(1);
//		referenceArtifact1.setName("reference artifact example");
//		referenceArtifact1.setFile("java.txt");
//		referenceArtifact1.setDescription("This is a reference artifact");
//		ReferenceArtifact referenceArtifact2 = new ReferenceArtifact();
//		SampleProgram sampleProgram1 = new SampleProgram();
//		sampleProgram1.setId(1);
//		sampleProgram1.setName("sample program example");
//		sampleProgram1.setFile("sample.txt");
//		sampleProgram1.setDescription("This is a sample program");
//		SampleProgram sampleProgram2 = new SampleProgram();
//		ReferenceUrl referenceUrl1 = new ReferenceUrl();
//		referenceUrl1.setId(1);
//		referenceUrl1.setName("reference url example");
//		referenceUrl1.setUrl("http://www.javase.com");
//		referenceUrl1.setDescription("This is a reference url");
//		List<ReferenceArtifact> refArtList = new ArrayList<ReferenceArtifact>();
//		refArtList.add(referenceArtifact1);
//		List<SampleProgram> samProgList = new ArrayList<SampleProgram>();
//		samProgList.add(sampleProgram1);
//		List<ReferenceUrl> refUrlList = new ArrayList<ReferenceUrl>();
//		refUrlList.add(referenceUrl1);
//		Level level = new Level();
//		level.setId(1);
//		level.setName("Level 1");
//		Category category = new Category();
//		category.setId(1);
//		category.setName("java");
//		video.setId(1);
//		video.setName("java");
//		video.setDisplayName("java");
//		video.setUrl("https://www.javase.com");
//		Time time = Time.valueOf("01:20:09");
//		video.setDuration(time);
//		video.setCreatedBy("Subhalakshmi");
//		Timestamp createTimestamp = new Timestamp(System.currentTimeMillis());
//		video.setCreatedOn(createTimestamp);
//		video.setModifiedBy("Subhalakshmi");
//		Timestamp modifyTimestamp = new Timestamp(System.currentTimeMillis());
//		video.setModifiedOn(modifyTimestamp);
//		video.setDescription("This is a java video");
//		video.setLevel(level);
//		video.setCategory(category);
//		video.setReferenceArtifact(refArtList);
//		video.setSampleProgram(samProgList);
//		video.setReferenceUrl(refUrlList);
//		videoList.add(video);
//		when(query.getResultList()).thenReturn(videoList);
//		assertNotNull(videodao.getAllVideos());
//		//when(videodao.getAllVideos()).thenReturn(videoList);
//		//List<Video> v=videodao.getAllVideos();
//		//assertEquals(videoList,videodao.getAllVideos());
//	}
	public List<Level> getLevelList() {

		Level level = new Level();
		level.setId(1);
		level.setName("level 1");
		levelList.add(level);
		return levelList;
	}

	public List<Category> getCategoryList() {

		Category category = new Category();
		category.setId(1);
		category.setName("java");
		categoryList.add(category);
		return categoryList;
	}
	@Test
	void testGetAllLevels() {
		//when(videodao.getAllLevels()).thenReturn(levelList);
		//List<Video> v=videodao.getAllVideos();
		List<Level> level=null;
//		level=videodao.getAllLevels();
//		assertNotNull(level);
		//assertEquals(levelList,videodao.getAllLevels());
	}

	@Test
	void testGetAllCategories() {
	
	}

	@Test
	void testGetVideoById() {
		
	}

	@Test
	void testGetActivatedVideos() {
		
	}

	@Test
	void testToggleStatus() {
		
	}

	@Test
	void testGetDeactivatedVideos() {
		
	}

	@Test
	void testDeleteVideoById() {
		
	}

	@Test
	void testDeleteReferenceArtifactById() {
		
	}

	@Test
	void testDeleteSampleProgramById() {
		
	}

	@Test
	void testDeleteReferenceUrlById() {
		
	}

	@Test
	void testAddVideo() {
		
	}

	@Test
	void testUpdateVideo() {
		
	}

	@Test
	void testDeactivateVideo() {
	
	}

}
