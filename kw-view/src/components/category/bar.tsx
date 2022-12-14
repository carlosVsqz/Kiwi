import {renderThemeClass} from '@common/functions';
import {ThemeVariation} from '@common/enum';
import React from 'react';
import {PostItemCategory} from '@store/slices/posts';
import Link from 'next/link';

const CategoryBar = ({ data, theme }: { data: PostItemCategory; theme?: ThemeVariation }) => {
  return (
    <Link href="/p/categoria/[id]" as={`/p/categoria/${data.id}`}>
      <a className={`category -bar ${renderThemeClass(theme)}`} href={`/p/categoria/${data.id}`}>
        <div className="category__background" style={{ backgroundImage: `url(${data.image})` }}></div>
        <h5 className="title">{data.name}</h5>
        <h5 className="quantity">{data.quantity}</h5>
      </a>
    </Link>
  );
};

export default CategoryBar;
