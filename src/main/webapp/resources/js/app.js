"use strict"
var app = app ||{}

app = (()=>{
	let _ , js, css, img 
	
	let run =x=>{
		$.getScript(x+'/resources/js/router.js', ()=>{
			$.extend(new Session(x))
			onCreate()
			init()
		})
	}
	let init =x=>{
		_ = $.ctx()
		js = $.js()
		css = $.css()
		img = $.img()
		
		//alert('dd' +x)
	
		
	}
	let onCreate =()=>{
		
		setContentView()
		
		
		
	}
	let setContentView =()=>{

		/*
		 * <style>
#tab {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#tab td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

#tab tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
		 */
		$('<table id="tab"><tr></tr></table>')
		.css({width:'80%' , height:'80%' , border: '1px solid black', margin:'0 auto'})
		.appendTo('#wrapper')
		$('<td/>', {id: 'left'})
		.css({width:'20%' , height:'100%' , border: '1px solid black', 'vertical-align': 'top'})
		.appendTo('tr')
		$('<td/>', {id:'right'})
		.css({width:'80%' , height:'100%' , border: '1px solid black'})
		.appendTo('tr')
		$.each(['naver','cgv','bugs'] , (i,j)=>{
			$('<div/>')
			.text(j)
			.css({
				width:'100%' , height:'10%' , border: '1px solid black', 'text-align': 'center'})
		
			.appendTo('#left')
			.click(function(){
				alert('in the '+_)
				switch($(this).text()){
				case 'naver':
					$.getJSON(_+'/crwal/naver', d=>{})
					break
				case 'cgv':
					$.getJSON(_+'/crwal/cgv', d=>{})
					break
				case 'bugs':
					$.getJSON(_+'/crwal/bugs', d=>{})
					break
				}
				
			})
			
		})
		
			
		
	}
	
	return {run}
	
})()