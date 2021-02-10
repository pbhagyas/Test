package io.javabrains.springbootstarter.tropic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class TopicService  //buissnessService Classcreate as singleton
{

		
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTropics()
	{
		List<Topic> topics= new ArrayList<Topic>();
		topicRepository.findAll().forEach(topics::add);
		return topics;

	} 
	
	public Optional<Topic> getTopic(String id)
	{
		return topicRepository.findById(id);
	}
 
	
	public void addtropic(Topic topic)
	{
		topicRepository.save(topic);
	}
	
	public void updateTropic(String id, Topic topic)
	{
		topicRepository.save(topic);
	}
	
	public void deleteTropic(String id)
	{
		topicRepository.deleteById(id);
	}
}
