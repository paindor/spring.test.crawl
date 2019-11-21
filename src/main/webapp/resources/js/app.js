"use strict"
var app = app ||{}

app = (()=>{
	const WHEN_ERR = 'js로드실패'
	let _ , js, css, img 
	
	let run =x=>{
		
		$.when(
				$.getScript(x+'/resources/js/router.js', ()=>{
					$.extend(new Session(x))
					
					
				}),
				$.getScript(x+'/resources/js/pop.js')
				
			).done(()=>{
				init()
				onCreate()
			
		})
		.fail(()=>{
			alert(WHEN_ERR)
			
		})
	}
	let init =()=>{
		_ = $.ctx()
		js = $.js()
		css = $.css()
		img = $.img()
		
		//alert('dd' +x)
	
		
	}
	let onCreate =()=>{
		$(pop.view()).appendTo('#wrapper')
		pop.open()
	
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
		.css({width:'80%' , height:'100%' , border: '1px solid black', margin:'0 auto'})
		.appendTo('#wrapper')
		$('<td/>', {id: 'left'})
		.css({width:'20%' , height:'900px' , border: '1px solid black', 'vertical-align': 'top'})
		.appendTo('tr')
		$('<td/>', {id:'right'})
		.css({width:'80%' , height:'100%' , border: '1px solid black' 
			})
		.appendTo('tr')
		$.each(['naver','cgv','bugs'] , (i,j)=>{
			$('<div/>')
			.text(j)
			.css({
				width:'100%' , height:'10%' , border: '1px solid black', 'text-align': 'center' , float:'center'})
		
			.appendTo('#left')
			.click(function(){
				$(this).css({'background-color': 'yellow'})
				//$(this).siblings().style.removeProperty('background-color')
				$(this).siblings().css({'background-color': 'white'})
				alert('in the '+_)
				switch($(this).text()){
				case 'naver':
					$.getJSON(_+'/crwal/naver', d=>{
					
						$('#right').empty()
						$.each(d,(i,j)=>{
							$('<div/>')
							.css({width:'40%', height:'40%',
								border: '3px solid olive',
								float: 'left',
								'vertical-align': 'center'
								})
							.html('<h1>'+j.origin+'</h1><h4>'+j.trans+'</h4>' )
							.appendTo('#right')
						})
					})
					break
				case 'cgv':
					
					$.getJSON(_+'/crwal/cgv', d=>{
						$('#right').empty()
						$.each(d,(i,j)=>{
							$('<div><img style="width:200px"  src="'+j.photo+'"/><br/>'+j.title+'<br/>'+j.textInfo+'<br/></div>')
							.css({
								border:'3px solid olive',
								float: 'left',
								
								
							})
							.appendTo('#right')
							
							
						})
						
					})
					
					break
				case 'bugs':
					list(0)
					
					break
				}
				
			})
			
		})
		
			
		
	}
	let list=x=>{
		$.getJSON(_+'/crwal/bugs/page/'+x, d=>{
			$('#right').empty()
			let pager = d.pager;
			let list = d.list;
			//alert('벅스' + list)
			//title artist thumbnail
			
			$('<table id="content"><tr id="head"></tr></table>')
			.css({width:'99%', 	
				height:'50px',
				border: '3px solid olive',
				
				})
			.appendTo('#right')
			$.each(['No', '제목', '가수', '앨범'],(i,j)=>{
				$('<th/>')
				.html('<b>'+j+'</b>')
				.css({width:'25%', 	
					height:'100%',
					border: '3px solid olive',
				
					
					})
				.appendTo('#head')
			})
			$.each(list, (i,j)=>{
				$('<tr><td>'+j.seq+'</td><td>'+j.title+'</td><td>'+j.artist+'</td><td><img src="'+j.thumbnail+'"/></td></tr>')
				.css({width:'20%', 	
					height:'100%',
					border: '3px solid olive',
					
					})
				.appendTo('#content tbody')
				//alert('title' +j.title)
			})
			$('#content tr td').css({border: '3px solid olive'})
			$('<div/>', {id:'pagination'})
			.css({width:'50%', 	
					height:'50px',
					margin:'20px auto',
					/*border: '3px solid olive'*/})
			.appendTo('#right')
			if(pager.existPrev){
				$('<span/>')
				.css({width: '50px',
					  height: '30px',
					  display: 'inline-block',
		              border: '1px solid black'})
				.text('Prev')
				.appendTo('#pagination')
				.click(()=>{
					app.list(pager.prevBlock)
				})
			}
			let start = pager.startPage
					let end = pager.endPage
			for( let i = start; i <=end ; i++){
				$('<span/>')
				.text(i+1)
				.css({width:'30px', 	
						height:'30px',
						display:'inline-block',
						margin:'0 auto',			
						border: '3px solid olive'})
				.appendTo('#pagination')
				.click(function(){
					let num = parseInt($(this).text())
					
					app.list(num-1)
					
					
				
					
				})
				
			}
			if(pager.existNext){
				$('<sapn/>')
				.css({width: '50px',
					  height: '30px',
					  display: 'inline-block',
		              border: '1px solid black'})
				.text('Next')
				.appendTo('#pagination')
				.click(()=>{
					app.list(pager.nextBlock)
				})
			}
			
			
			
		/*	
			
	
			
			$.each(pager,(i,j)=>{
				alert(i)
				$('<a>'+(i+1)+'</a>')
				.appendTo('#right span')
				
			})
			*/
			
		/*	$.each([],()=>{
				
			})
			*/
		
		})
	}
	return {run, list}
	
})()