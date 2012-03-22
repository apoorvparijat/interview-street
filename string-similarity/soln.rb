num_inputs = gets.chop.to_i
str = []
num_inputs.times { str << gets.chop }

find_similar = lambda { |x,y|
	count = 0
	#puts "Finding similar: ", x, y
	m = x.length < y.length ? x.length : y.length
	0.upto(m-1) do |i|
		#puts "\t x[i] and y[i] is #{x[i]}, #{y[i]}"
		count += 1 if x[i] == y[i]
		#puts "Count is #{count}"
		break if x[i] != y[i]
	end
	count
} 



suffix_similarity = lambda { |x|
	count = 0
	m = x.length
	#puts "m is #{m}"
	0.upto(m-1) do |i|
		#puts "Calling find_similar with #{x[i,m]} (i = #{i})"
		count += find_similar[x,x[i,m]] 
	end
	count
}

0.upto(num_inputs-1) {|i|
	puts suffix_similarity[str[i]]
}
