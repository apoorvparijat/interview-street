class City
	
	@@cityCount = 0
	attr_accessor :cityNo, :visited

	def initialize 
		@cityNo = @@cityCount
		@@cityCount = @@cityCount+1 
		@visited = 0
		$maps[@cityNo] = Array.new
	end


	def addRoad (cityNo)
		$maps[@cityNo] << cityNo if cityNo.class == Fixnum
		$maps[@cityNo] << cityNo.cityNo if cityNo.class == City
	end

	def isConnectedTo id
		$maps[@cityNo].each{|x|
			return true if x == id
		}
		false
	end
	
	def self.connectCities(c1,c2)
		c1.addRoad(c2)
		#puts c1.cityNo.to_s + "->" + c2.cityNo.to_s
	end
	
	def getRoads
		return $maps[@cityNo]
	end
end

$maps = Array.new
numCity,numRoad = gets.split(" ")
city = Array.new(numCity.to_i)
1.upto(numCity.to_i) { |x| city[x-1] = City.new} 
1.upto(numRoad.to_i) do |x|
	str = gets
	c1id, c2id = str.split(" ")
	City::connectCities(city[c1id.to_i-1],city[c2id.to_i-1])
end


queue = Array.new
$paths = 0
def dfs(kingdom,cn,numCity,queue)
	return if $paths == -1
	#puts "\n# dfs starting at #{cn} and numCity,paths = #{numCity}, #{$paths}"
	queue[cn]= true
	c = kingdom[cn]
		arr = c.getRoads
		ctr = 0
		arr.each {|ctr|
			#print ctr.to_s + " -> "
			unless queue[ctr] 
				#puts "\n ctr is ", ctr
				dfs(kingdom,ctr,numCity,queue)
				queue[ctr] = false
			else
					#puts "############ unsetting paths ################"
				$paths = -1
			end
				#puts "\n# deadend with starting point #{cn} and route #{cn} -> #{ctr}."
			ctr += 1
		} 
	if(cn == numCity-1 && $paths >= 0)
		#puts "############### found a new path ###############"
		$paths = $paths + 1 
	end
	#puts "\n# no more routes at #{cn}"
end

dfs(city,0,numCity.to_i,queue)
$paths = $paths == -1 ? "INFINITE PATHS" : $paths
print $paths