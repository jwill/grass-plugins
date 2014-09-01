@Grapes(
    	@Grab(group='de.sven-jacobs', module='loremipsum', version='1.0')
)

import java.text.SimpleDateFormat
import de.svenjacobs.loremipsum.LoremIpsum

def format = new SimpleDateFormat('yyyy-MM-dd')

def lorem = new LoremIpsum()

def generatePost = {
  def post = """<%
      title '${lorem.getWords(5)}
      tag '${lorem.getWords(1,0)}, ${lorem.getWords(1,1)}'
      description 'No description here'
  %>"""
  def numParas = (int)Math.random()*5
  if (numParas == 0) numParas = 1
  post += "\n" + lorem.getParagraphs(numParas)
  return post
}

for (i in 0..5) {
  def filename = format.format(new Date()+i) + "-" + lorem.getWords(5).replaceAll(',','').replaceAll(' ', '-') + ".md"
  def file = new File(filename)
  file.write(generatePost())
}

println "Done."
