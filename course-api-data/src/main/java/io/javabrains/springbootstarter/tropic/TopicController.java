package io.javabrains.springbootstarter.tropic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController 
{
	@Autowired
	private TopicService topicService;
	
	
	@RequestMapping("/topics")
	public List<Topic> getAllTropics()
	{
		 return topicService.getAllTropics();      //springMVC FW  maps the /tropic request to getalltropic method and converests the return to JSON automaticlly bcz of annotation
	}                                             
 
	@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable("id") String id)
	{
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics")
	public void addTropic(@RequestBody Topic tropic)
	{
		topicService.addtropic(tropic);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTropic(@RequestBody Topic tropic,@PathVariable String id)
	{
		topicService.updateTropic(id,tropic);
	}

	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void deleteTropic(@PathVariable String id)
	{
		topicService.deleteTropic(id);
	}
}  
