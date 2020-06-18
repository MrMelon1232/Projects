#Question 4

class Shape
    attr_accessor :perimeter, :area, :print
    
    def initialize()
    end
    
    def print()
        if perimeter == nil && area == nil
            puts "The shape is #{self.class}, the perimeter is undefined, the area is undefined."
        elsif perimeter == nil
            puts "The shape is #{self.class}, the perimeter is undefined, the area is #{self.area}."
        elsif area == nil
            puts "The shape is #{self.class}, the perimeter is #{self.perimeter}, the area is undefined."
        else
            puts "The shape is #{self.class}, the perimeter is #{self.perimeter}, the area is #{self.area}."
        end
        
    end
    
    def perimeter()
        nil
    end
    
    def area()
        nil
    end

end

class Circle < Shape
    attr_accessor :perimeter, :area, :print
    
    def print()
        super()
    end
    
    
    def initialize(radius)
        @radius = radius
    end
    
    def perimeter()
        @perimeter = 2 * 3.141592653 * @radius
    end
    
    def area()
        @area =  3.141592653 * @radius * @radius
    end
end



class Rectangle < Shape
    attr_accessor :perimeter, :area, :print
    
    def print()
        super()
    end
    
    def initialize(width, height)
        @width = width
        @height = height
    end
    
    def perimeter()
        if @width == 0 || @height == 0
            @perimeter = 0
        else
            @perimeter = 2* @width + 2* @height
        end
    end
    
     def area()
        @area = @width * @height
    end
    
end

class Ellipse < Shape
    attr_accessor :area, :eccentricity
    def initialize(a, b)
        super()
        @a = a
        @b = b
    end
    
    def print()
        super()
    end

    def area()
        @area = 3.141592653 * @a * @b
    end
    
    def eccentricity()
        @eccentricity = Math.sqrt(@a * @a - @b * @b)
    end
end



#Question 5
$a = 0
$b = 0
$counter = 0
filename = "ok.txt"
$shapecnt = 0
$reccnt = 0
$circcnt = 0
$ellcnt = 0

File.foreach(filename) {|line|

if line.include? "shape"
    s = Shape.new()
    s.print
    $shapecnt += 1
end    

if line.include? "circle"
    line.split(" ").each do |i|
        if i == "circle"
            next
        elsif i.to_i.is_a?(Integer)
            $a = i.to_i
        end
    end
    if $a >=0 && $b >=0
        c = Circle.new($a)
        c.print
        $shapecnt += 1
        $circcnt += 1
    else
        puts "Error: Invalid Circle"
    end
end

if line.include? "rectangle"

    line.split(" ").each do |i|
        if i == "rectangle"
            next
        elsif i.to_i.is_a?(Integer) && $counter == 0
                $a = i.to_i
                $counter += 1
                next

        elsif i.to_i.is_a?(Integer) && $counter == 1
                $b = i.to_i
                $counter = 0
                next
        end
    end

    if $a >=0 && $b >=0
        r = Rectangle.new($a, $b)
        r.print
        $shapecnt += 1
        $reccnt += 1
    else
        puts "Error: Invalid Rectangle"
    end
end

if line.include? "ellipse"
    line.split(" ").each do |i|
        if i == "ellipse"
            next
        elsif i.to_i.is_a?(Integer) && $counter == 0
                $a = i.to_i
                $counter += 1
                next

        elsif i.to_i.is_a?(Integer) && $counter == 1
                $b = i.to_i
                $counter = 0
                next
        end
    end
    if $a >=0 && $b >=0 
        e = Ellipse.new($a, $b)
        e.print
        $shapecnt += 1
        $ellcnt += 1
    else
        puts "Error: Invalid Ellipse"
    end
end 
}

#Question 6

shapes = {
"Shape(s):" => $shapecnt,
"Rectangle(s):" => $reccnt,
"Circle(s):" => $circcnt,
"Ellipse(s):" => $ellcnt
}

puts "\nStatistics:"
shapes.each_pair do |key, value|
    puts "\t#{key} #{value}"
end