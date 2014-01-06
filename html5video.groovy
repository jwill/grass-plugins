class HTML5VideoPlugin {
  def config

  def setupBinding(binding) {
	//srcUrl, autoPlay, posterURL, subtitles
	binding.video = {Map args  ->
	  if (args.autoPlay != null && maps.autoplay != false)
		autoPlay = "autoplay"
	  else autoplay = ""
	  def subtitles = processSubtitles(args)
	  """<video src="${args.srcUrl}" ${autoplay} ></video>"""
	}
  }

  def processSubtitles = { args ->
	// [src: "foo.en.vtt", lang: "en"
	def output = ""
	if (args.subtitles != null) {
	  
	}
  }
}