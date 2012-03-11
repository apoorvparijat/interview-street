class City
	
	@@cityCount = 0
	attr_accessor :cityNo, :visited

	def initialize 
		@cityNo = @@cityCount
		@connection = Array.new
		@@cityCount = @@cityCount+1 
		@visited = 0
	end


	def addRoad (cityNo)
		@connection[cityNo] = true if cityNo.class == Fixnum
		@connection[cityNo.cityNo] = true if cityNo.class == City
	end

	def showRoads
		print @connection.join(",") + "\n"
	end

	def isConnectedTo id
		return @connection[id]
	end
	
	def self.connectCities(c1,c2)
		c1.addRoad(c2)
		puts c1.cityNo.to_s + "->" + c2.cityNo.to_s
	end
	
	def getRoads
		@connection
	end
end


numCity,numRoad = gets.split(" ")
city = Array.new(numCity.to_i)
1.upto(numCity.to_i) { |x| city[x-1] = City.new} 
1.upto(numRoad.to_i) do |x|
	str = gets
	c1id, c2id = str.split(" ")
	City::connectCities(city[c1id.to_i-1],city[c2id.to_i-1])
end


queue = Array.new

def dfs(kingdom,cn)
	puts "\n# dfs starting at #{cn}"
	
	c = kingdom[cn];
	c.visited = 1
		arr = c.getRoads
		ctr = 0
		arr.each {|x|
			unless (x == nil)
				print ctr.to_s + " -> "
				dfs(kingdom,ctr) if kingdom[ctr].visited == 0
				puts "\n# deadend with starting point #{cn} and route #{cn} -> #{ctr}."
			end
			ctr += 1
		} 
	puts "\n# no more routes at #{cn}"
end

dfs(city,0);